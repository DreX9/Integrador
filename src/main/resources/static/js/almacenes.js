document.addEventListener('DOMContentLoaded', function() {
    // Referencias a elementos del DOM
    const almacenesForm = document.getElementById('almacenesForm');
    const almacenId = document.getElementById('almacenId');
    const nombreAlmacen = document.getElementById('nombreAlmacen');
    const direccionAlmacen = document.getElementById('direccionAlmacen');
    const descripcionAlmacen = document.getElementById('descripcionAlmacen');
    const btnGuardar = document.getElementById('btnGuardar');
    const btnLimpiar = document.getElementById('btnLimpiar');
    const almacenesTable = document.getElementById('almacenesTable').getElementsByTagName('tbody')[0];

    // Cargar los almacenes al iniciar la página
    cargarAlmacenes();

    // Evento para guardar/actualizar un almacén
    btnGuardar.addEventListener('click', function() {
        if (!validarFormulario()) return;

        const almacen = {
            nombre: nombreAlmacen.value,
            direccion: direccionAlmacen.value,
            descripcion: descripcionAlmacen.value
        };

        if (almacenId.value) {
            // Actualizar almacén existente
            actualizarAlmacen(almacenId.value, almacen);
        } else {
            // Crear nuevo almacén
            crearAlmacen(almacen);
        }
    });

    // Evento para limpiar el formulario
    btnLimpiar.addEventListener('click', limpiarFormulario);

    // Función para validar el formulario
    function validarFormulario() {
        if (!nombreAlmacen.value.trim()) {
            alert('El nombre del almacén es obligatorio');
            nombreAlmacen.focus();
            return false;
        }
        if (!direccionAlmacen.value.trim()) {
            alert('La dirección del almacén es obligatoria');
            direccionAlmacen.focus();
            return false;
        }
        return true;
    }

    // Función para cargar todos los almacenes
    function cargarAlmacenes() {
        fetch('/api/almacenes')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al cargar los almacenes');
                }
                return response.json();
            })
            .then(data => {
                console.log("Datos recibidos:", data); // Para depuración
                mostrarAlmacenes(data);
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error al cargar los almacenes');
            });
    }

    // Función para mostrar los almacenes en la tabla
    function mostrarAlmacenes(almacenes) {
        // Limpiar la tabla
        almacenesTable.innerHTML = '';

        if (almacenes.length === 0) {
            const row = almacenesTable.insertRow();
            const cell = row.insertCell(0);
            cell.colSpan = 4;
            cell.textContent = 'No hay almacenes registrados';
            cell.className = 'text-center';
            return;
        }

        // Agregar cada almacén a la tabla
        almacenes.forEach(almacen => {
            const row = almacenesTable.insertRow();
            
            // Añadir celdas con la información del almacén
            const nombreCell = row.insertCell(0);
            nombreCell.textContent = almacen.nombre;
            
            const direccionCell = row.insertCell(1);
            direccionCell.textContent = almacen.direccion;
            
            const descripcionCell = row.insertCell(2);
            descripcionCell.textContent = almacen.descripcion || '-';
            
            // Añadir botones de acción
            const accionesCell = row.insertCell(3);
            accionesCell.innerHTML = `
                <button class="btn btn-sm btn-outline-primary me-1 btn-editar" data-id="${almacen.id}">
                    <i class="bi bi-pencil"></i>
                </button>
                <button class="btn btn-sm btn-outline-danger btn-eliminar" data-id="${almacen.id}">
                    <i class="bi bi-trash"></i>
                </button>
            `;
        });

        // Agregar eventos a los botones de acción
        document.querySelectorAll('.btn-editar').forEach(btn => {
            btn.addEventListener('click', function() {
                editarAlmacen(this.getAttribute('data-id'));
            });
        });

        document.querySelectorAll('.btn-eliminar').forEach(btn => {
            btn.addEventListener('click', function() {
                eliminarAlmacen(this.getAttribute('data-id'));
            });
        });
    }

    // Función para crear un nuevo almacén
    function crearAlmacen(almacen) {
        fetch('/api/almacenes', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(almacen)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al crear el almacén');
            }
            return response.json();
        })
        .then(data => {
            alert('Almacén creado correctamente');
            limpiarFormulario();
            cargarAlmacenes(); // Recargar la tabla
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error al crear el almacén');
        });
    }

    // Función para cargar un almacén para editar
    function editarAlmacen(id) {
        fetch(`/api/almacenes/${id}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error al cargar el almacén');
                }
                return response.json();
            })
            .then(data => {
                // Llenar el formulario con los datos del almacén
                almacenId.value = data.id;
                nombreAlmacen.value = data.nombre;
                direccionAlmacen.value = data.direccion;
                descripcionAlmacen.value = data.descripcion || '';
                
                // Cambiar el texto del botón
                btnGuardar.textContent = 'Actualizar';
                
                // Desplazarse al formulario
                almacenesForm.scrollIntoView({ behavior: 'smooth' });
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Error al cargar el almacén para editar');
            });
    }

    // Función para actualizar un almacén
    function actualizarAlmacen(id, almacen) {
        fetch(`/api/almacenes/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(almacen)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al actualizar el almacén');
            }
            return response.json();
        })
        .then(data => {
            alert('Almacén actualizado correctamente');
            limpiarFormulario();
            cargarAlmacenes(); // Recargar la tabla
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error al actualizar el almacén');
        });
    }

    // Función para eliminar un almacén
    function eliminarAlmacen(id) {
        if (!confirm('¿Está seguro que desea eliminar este almacén?')) return;

        fetch(`/api/almacenes/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al eliminar el almacén');
            }
            alert('Almacén eliminado correctamente');
            cargarAlmacenes(); // Recargar la tabla
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error al eliminar el almacén');
        });
    }

    // Función para limpiar el formulario
    function limpiarFormulario() {
        almacenId.value = '';
        almacenesForm.reset();
        btnGuardar.textContent = 'Guardar';
    }
});