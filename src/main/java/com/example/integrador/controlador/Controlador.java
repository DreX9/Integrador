package com.example.integrador.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.integrador.interfacesService.IalmacenService;
import com.example.integrador.interfacesService.IclasificacionService;
import com.example.integrador.interfacesService.IclienteService;
import com.example.integrador.interfacesService.IproveedorService;
import com.example.integrador.interfacesService.IrolService;
import com.example.integrador.interfacesService.IusuarioService;
import com.example.integrador.modelo.Almacen;
import com.example.integrador.modelo.Clasificacion;
import com.example.integrador.modelo.Cliente;
import com.example.integrador.modelo.Proveedor;
import com.example.integrador.modelo.Rol;
import com.example.integrador.modelo.Usuario;

import jakarta.validation.Valid;




@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IalmacenService service;
    @Autowired
    private IclasificacionService clasService;
    @Autowired
    private IproveedorService provService;
    @Autowired
    private IusuarioService usuaService;
    @Autowired
    private IclienteService clieService;
    @Autowired
    private IrolService rolService;

    //ALMACENES
    @GetMapping("/almacenes")
    public String listarAlmacenes(Model model) {
        List<Almacen> almacenes = service.listar();
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("almacen", new Almacen());
        return "almacenes";
    }

    @PostMapping("/save")
    public String saveAlmacenes(@Valid Almacen a, Model model) {
        service.save(a);
        return "redirect:/almacenes";
    }

    @GetMapping("/editar/{id_almacen}")
    public String editarAlmacenes(@PathVariable int id_almacen, Model model) {
        Optional<Almacen> almacen = service.listarId(id_almacen);
        List<Almacen> almacenes = service.listar();
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("almacen", almacen.get());
        return "almacenes";
    }

    @GetMapping("/eliminar/{id_almacen}")
    public String deleteAlmacenes(@PathVariable int id_almacen, Model model) {
        service.delete(id_almacen);
        return "redirect:/almacenes";
    }

    //CLASIFICACIONES
    @GetMapping("/clasificaciones")
    public String listarClasificaciones(Model model) {
        List<Clasificacion> clasificaciones = clasService.listar();
        model.addAttribute("clasificaciones", clasificaciones);
        model.addAttribute("clasificacion", new Clasificacion());
        return "clasificaciones";
    }

    @PostMapping("/saveClasificacion")
    public String saveClasificacion(@Valid Clasificacion c, Model model) {
        clasService.save(c);
        return "redirect:/clasificaciones";
    }

    @GetMapping("/editarClasificaciones/{id_clasificacion}")
    public String editarClasificaciones(@PathVariable int id_clasificacion, Model model) {
        Optional<Clasificacion> clasificacion = clasService.listarId(id_clasificacion);
        List<Clasificacion> clasificaciones = clasService.listar();
        model.addAttribute("clasificaciones", clasificaciones);        
        model.addAttribute("clasificacion", clasificacion.get());
        return "clasificaciones"; 
    }

    @GetMapping("/deleteClasificaciones/{id_clasificacion}")
    public String deleteClasificaciones(@PathVariable int id_clasificacion, Model model) {
        clasService.delete(id_clasificacion);
        return "redirect:/clasificaciones";
    }

    //CLIENTES
    @GetMapping("/clientes")
    public String listarClientes(Model model) {
        List<Cliente> clientes = clieService.listar();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", new Cliente());
        return "clientes";
    }

    @PostMapping("/saveCliente")
    public String saveCliente(@Valid Cliente c, Model model) {
        clieService.save(c);
        return "redirect:/clientes";
    }

    @GetMapping("/editarClientes/{id_cliente}")
    public String editarClientes(@PathVariable int id_cliente, Model model) {
        Optional<Cliente> cliente = clieService.listarId(id_cliente);
        List<Cliente> clientes = clieService.listar();
        model.addAttribute("clientes", clientes);
        model.addAttribute("cliente", cliente.get());
        return "clientes";
    }

    @GetMapping("/deleteClientes/{id_cliente}")
    public String deleteClientes(@PathVariable int id_cliente, Model model) {
        clieService.delete(id_cliente);
        return "redirect:/clientes";
    }

    //COMPRAS
    @GetMapping("/compras")
    public String compras () {
        return "compras";
    }

    //DEVOLUCION-COMPRA
    @GetMapping("/devolucion-compra")
    public String devolucionCompra () {
        return "devolucion-compra";
    }

    //DEVOLUCION-VENTA
    @GetMapping("/devolucion-venta")
    public String devolucionVenta () {
        return "devolucion-venta";
    }

    //INDEX (LOGIN)
    @GetMapping
    public String inicio () {
     return "index";
    }

    //INVENTARIOS
    @GetMapping("/inventarios")
    public String inventarios () {
        return "inventarios";
    }

    //PRODUCTOS
    @GetMapping("/productos")
    public String productos () {
        return "productos";
    }

    //PROVEEDORES
    @GetMapping("/proveedores")
    public String listarProveedores(Model model) {
        List<Proveedor> proveedores = provService.listar();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("proveedor", new Proveedor());
        return "proveedores";
    }

    @PostMapping("/saveProveedor")
    public String saveProveedor(@Valid Proveedor p, Model model) {
        provService.save(p);
        return "redirect:/proveedores";
    }

    @GetMapping("/editarProveedores/{id_proveedor}")
    public String editarProveedores(@PathVariable int id_proveedor, Model model) {
        Optional<Proveedor> proveedor = provService.listarId(id_proveedor);
        List<Proveedor> proveedores = provService.listar();
        model.addAttribute("proveedores", proveedores);
        model.addAttribute("proveedor", proveedor.get());
        return "proveedores";
    }

    @GetMapping("/eliminarProveedores/{id_proveedor}")
    public String deleteProveedor(@PathVariable int id_proveedor, Model model) {
        provService.delete(id_proveedor);
        return "redirect:/proveedores";
    }

    //REPORTES
    @GetMapping("/reportes")
    public String reportes () {
    return "reportes";
    }

    //ROLES
    @GetMapping("/roles")
    public String listarRoles(Model model) {
        List<Rol> roles = rolService.listar();
        model.addAttribute("roles", roles);
        model.addAttribute("rol", new Rol());
        return "roles";
    }

    @PostMapping("/saveRoles")
    public String saveRoles(@Valid Rol r, Model model) {
        rolService.save(r);
        return "redirect:/roles";
    }

    @GetMapping("/editarRoles/{id_rol}")
    public String editarRoles(@PathVariable int id_rol, Model model) {
        Optional<Rol> rol = rolService.listarId(id_rol);
        List<Rol> roles = rolService.listar();
        model.addAttribute("roles", roles);        
        model.addAttribute("rol", rol.get());
        return "roles"; 
    }

    @GetMapping("/deleteRoles/{id_rol}")
    public String deleteRoles(@PathVariable int id_rol, Model model) {
        clasService.delete(id_rol);
        return "redirect:/roles";
    }

    //USUARIOS
    @GetMapping("/usuarios")
    public String listarUsuarios (Model model) {
        List<Usuario>usuarios = usuaService.listar();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", new Usuario());
        return "usuarios";
    }

    @PostMapping("/saveUsuario")
    public String saveUsuario(@ModelAttribute("usuario") Usuario u, Model model) {
        usuaService.save(u);
        return "redirect:/usuarios";
    }

    @GetMapping("/editarUsuarios/{id_usuario}")
    public String editarUsuarios(@PathVariable int id_usuario, Model model) {
        Optional<Usuario> usuario = usuaService.listarId(id_usuario);
        List<Usuario> usuarios = usuaService.listar();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario", usuario.get());
        return "usuarios";
    }

    @GetMapping("/deleteUsuarios/{id_usuario}")
    public String deleteUsuarios(@PathVariable int id_usuario, Model model) {
        usuaService.delete(id_usuario);
        return "redirect:/usuarios";
    }

    //VENTAS
    @GetMapping("/ventas")
    public String ventas () {
        return "ventas";
    }
}
