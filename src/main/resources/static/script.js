$(document).ready(function() {
    // Форма добавления книги
    $('#addBookForm').submit(function(event) {
        event.preventDefault();
        var bookName = $('#bookName').val();
        var bookPrice = $('#bookPrice').val();
        var bookDescription = $('#bookDescription').val();
        var newBook = {
            name: bookName,
            price: bookPrice,
            description: bookDescription
        };
        // Отправка данных о новой книге на сервер
        $.ajax({
            type: 'POST',
            url: '/api/book/add',
            contentType: 'application/json',
            data: JSON.stringify(newBook),
            success: function(data) {
                alert('Книга успешно добавлена!');
                // Очищаем поля формы после успешного добавления
                $('#bookName').val('');
                $('#bookPrice').val('');
                $('#bookDescription').val('');
            },
            error: function() {
                alert('Ошибка при добавлении книги!');
            }
        });
    });

    // Поиск книг по автору
    $('#searchForm').submit(function(event) {
        event.preventDefault();
        var authorName = $('#authorName').val();
        $.get('/api/author/books/' + authorName, function(data) {
            var bookContainer = $('#bookContainer');
            bookContainer.empty(); // Очищаем контейнер перед добавлением нового содержимого
            if (data.length > 0) {
                var ul = $('<ul>');
                data.forEach(function(book) {
                    ul.append($('<li>').text(book.name));
                });
                bookContainer.append(ul);
            } else {
                bookContainer.text('Список книг по автору пуст');
            }
        });
    });
});
