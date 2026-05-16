# CES-INTRODUCCI-N-A-LA-PROGRAMACI-N-PARA-TESTERS
# Funcionalidades detectadas

## 1. Registro / Creación de Usuario

### Descripción
Permite crear nuevas cuentas de usuarios testers dentro del sistema.

### Datos utilizados
- Nombre
- Apellido
- Email
- País de nacimiento
- Contraseña por defecto
- Perfil del tester:
    - Tester Junior
    - Tester Senior
    - Tester Líder

### Acciones disponibles
- Crear cuenta
- Volver

---

## 2. Gestión de Roles de Usuario

### Descripción
Permite asignar un perfil o nivel al usuario durante la creación de la cuenta.

### Datos utilizados
- Tipo de perfil:
    - Tester Junior
    - Tester Senior
    - Tester Líder

### Observaciones
Cada perfil posiblemente determine distintos permisos o accesos dentro del sistema.

---

## 3. Reinicio de Contraseña

### Descripción
Permite modificar la contraseña de un usuario registrado.

### Datos utilizados
- Email
- Nueva contraseña
- Repetir contraseña

### Acciones disponibles
- Reiniciar contraseña
- Volver

### Validaciones detectadas
- Verificar que el email exista
- Verificar coincidencia entre ambas contraseñas

---

## 4. Acceso / Inicio de Sesión

### Descripción
Permite navegar entre el registro de usuarios y el acceso al sistema.

### Opciones detectadas
- Crear cuenta!
- Ya tengo cuenta!

### Observaciones
Corresponde a la navegación básica de autenticación del sistema.

---

## 5. Visualización de Usuarios

### Descripción
Muestra un listado de usuarios administrados dentro del sistema.

### Datos visualizados
- Nombre
- Apellido
- Email
- País
- Perfil

### Acciones disponibles
- Eliminar usuario

---

## 6. Eliminación de Usuarios

### Descripción
Permite eliminar usuarios registrados desde el listado general.

### Datos utilizados
- Información del usuario seleccionado:
    - Nombre
    - Apellido
    - Email
    - País
    - Perfil

### Riesgos o consideraciones
- Confirmación previa de eliminación
- Validación de permisos administrativos
- Evitar eliminación accidental

---

## 7. Listado de Usuarios Administrados

### Descripción
Muestra una sección textual o informativa relacionada con los usuarios gestionados por el administrador.

### Datos utilizados
- Información general de usuarios registrados