// Inicializar el calendario con flatpickr
flatpickr("#fechaCompra", {
    dateFormat: "d/m/Y",
    locale: {
        firstDayOfWeek: 1,
        weekdays: {
            shorthand: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sa'],
            longhand: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado']
        },
        months: {
            shorthand: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
            longhand: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre',
                'Octubre', 'Noviembre', 'Diciembre']
        }
    }
});

// Validar que solo se ingresen números en campos específicos
document.querySelectorAll('.numeric-only').forEach(input => {
    input.addEventListener('input', function () {
        this.value = this.value.replace(/[^0-9.]/g, '');
    });
});

// Obtener el stock disponible al seleccionar un producto
document.getElementById('producto').addEventListener('change', function () {
    // Simulación para la demostración
    document.getElementById('stockDisponible').value = Math.floor(Math.random() * 100);
});

// Funcionalidad para agregar filas a la tabla
document.getElementById('btnComprar').addEventListener('click', function () {
    // Obtener valores del formulario
    const proveedor = document.getElementById('proveedor');
    const clasificacion = document.getElementById('clasificacion');
    const producto = document.getElementById('producto');
    const precioUnitario = document.getElementById('precioUnitario');
    const peso = document.getElementById('peso');
    const cantidad = document.getElementById('cantidad');
    const almacen = document.getElementById('almacen');
    const fechaCompra = document.getElementById('fechaCompra');

    // Validar que los campos requeridos no estén vacíos
    if (proveedor.value === '' || producto.value === '' || cantidad.value === '') {
        alert('Por favor complete los campos requeridos');
        return;
    }

    // Crear nueva fila en la tabla
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
                <td>${proveedor.options[proveedor.selectedIndex].text}</td>
                <td>${clasificacion.options[clasificacion.selectedIndex].text}</td>
                <td>${producto.options[producto.selectedIndex].text}</td>
                <td>${precioUnitario.value}</td>
                <td>${peso.value}</td>
                <td>${cantidad.value}</td>
                <td>${almacen.value}</td>
                <td>${fechaCompra.value}</td>
            `;

    // Agregar la fila a la tabla
    document.querySelector('#comprasTable tbody').appendChild(newRow);

    // Limpiar el formulario
    document.getElementById('comprasForm').reset();
});