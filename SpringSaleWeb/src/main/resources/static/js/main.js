function deleteProduct(endpoint) {
    if (confirm("Bạn chắc chắn xóa?") === true) {
        // Lấy CSRF token từ meta tags
        const token = document.querySelector("meta[name='_csrf']").getAttribute("content");
        const header = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

        fetch(endpoint, {
            method: "delete",
            headers: {
                [header]: token // Thêm token vào header
            }
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống đang có lỗi!");
        }).catch(err => {
            console.error("Lỗi khi gửi yêu cầu:", err);
            alert("Đã xảy ra lỗi không mong muốn!");
        });
    }
}