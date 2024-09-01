$('#productModal').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget); // Button that triggered the modal
    const productId = button.data('id'); // Extract info from data-* attributes

    // Use AJAX to fetch user details
    $.ajax({
        url: '/product/' + productId,
        method: 'GET',
        success: function(data) {
            const modal = $('#productModal');
            modal.find('.modal-body h3').text(data.name);
            modal.find('.modal-body p').text(data.description);
            modal.find('.modal-body img').attr('src', '/images/' + data.image);
        }
    });
});

