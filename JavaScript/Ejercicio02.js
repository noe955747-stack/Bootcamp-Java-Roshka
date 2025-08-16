let a = 3;
let b = 19;
let c = 10;
let num = b ** 2 - 4 * a * c;
if (num >= 0) {
    let cua = (-b - Math.sqrt(num)) / (2 * a);
    console.log("Raíz:", cua);
} else {
    console.log("No hay raíces reales para ", num);
}