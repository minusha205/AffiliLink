const apiUrl = 'http://localhost:8080/api/v1/product';  // Ensure this matches your backend API URL

function saveProduct() {
    const form = document.getElementById('productForm');
    const formData = new FormData(form);

    const productData = {
        name: formData.get('name'),
        description: formData.get('description'),
        price: formData.get('price'),
        affiliateLink: formData.get('affiliateLink'),
        image: formData.get('image'),
        qty: formData.get('qty')
    };

    fetch(`${apiUrl}/save`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(productData)
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').innerText = 'Product saved successfully!';
            console.log('Success:', data);
        })
        .catch((error) => {
            document.getElementById('response').innerText = 'Error saving product.';
            console.error('Error:', error);
        });
}

function updateProduct() {
    const form = document.getElementById('productForm');
    const formData = new FormData(form);
    const productId = formData.get('productId');

    if (!productId) {
        alert('Please enter Product ID to update');
        return;
    }

    const productData = {
        name: formData.get('name'),
        description: formData.get('description'),
        price: formData.get('price'),
        affiliateLink: formData.get('affiliateLink'),
        image: formData.get('image'),
        qty: formData.get('qty')
    };

    fetch(`${apiUrl}/update/${productId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(productData)
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').innerText = 'Product updated successfully!';
            console.log('Success:', data);
        })
        .catch((error) => {
            document.getElementById('response').innerText = 'Error updating product.';
            console.error('Error:', error);
        });
}

function deleteProduct() {
    const form = document.getElementById('productForm');
    const formData = new FormData(form);
    const productId = formData.get('productId');

    if (!productId) {
        alert('Please enter Product ID to delete');
        return;
    }

    fetch(`${apiUrl}/delete/${productId}`, {
        method: 'DELETE'
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').innerText = 'Product deleted successfully!';
            console.log('Success:', data);
        })
        .catch((error) => {
            document.getElementById('response').innerText = 'Error deleting product.';
            console.error('Error:', error);
        });
}