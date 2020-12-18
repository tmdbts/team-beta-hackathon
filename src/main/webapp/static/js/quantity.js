function increment(quantitySpanId) {
    let quantitySpan = document.getElementById('quantity' + quantitySpanId);
    let quantity = quantitySpan.innerHTML;

    quantitySpan.innerHTML = quantity++;
}

function decrement() {
    let quantitySpan = document.getElementById('quantity' + quantitySpanId);
    let quantity = quantitySpan.innerHTML;

    if (quantitySpan.innerHTML < 1) {
        return;
    }

    quantitySpan.innerHTML = quantity--;
}
