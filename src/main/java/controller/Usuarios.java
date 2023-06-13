package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.UsuariosDao;
import models.UsuariosVo;

public class Usuarios extends HttpServlet {

    UsuariosVo r = new UsuariosVo();
    UsuariosDao rd = new UsuariosDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        System.out.println(accion);

        switch (accion) {

            case "consultar":
                req.getRequestDispatcher("consultar.jsp").forward(req, resp);
                break;

            case "Consultarr":
                req.getRequestDispatcher("Consultarr.jsp").forward(req, resp);
                break;

            case "Daviplata":
                req.getRequestDispatcher("Daviplata.jsp").forward(req, resp);
                break;

            case "Daviplataa":
                req.getRequestDispatcher("Daviplataa.jsp").forward(req, resp);
                break;

            case "index":
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;

            case "login":
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                break;

            case "menu":
                req.getRequestDispatcher("menu.jsp").forward(req, resp);
                break;

            case "Nequi":
                req.getRequestDispatcher("Nequi.jsp").forward(req, resp);
                break;

            case "Nequii":
                req.getRequestDispatcher("Nequii.jsp").forward(req, resp);
                break;

            case "Recargar":
                req.getRequestDispatcher("Recargar.jsp").forward(req, resp);
                break;

            case "Recargaa":
                req.getRequestDispatcher("Recargaa.jsp").forward(req, resp);
                break;

            case "sacar":
                req.getRequestDispatcher("sacar.jsp").forward(req, resp);
                break;

            case "sacarr":
                req.getRequestDispatcher("sacarr.jsp").forward(req, resp);
                break;
            case "Usuarios":
                req.getRequestDispatcher("Usuarios.jsp").forward(req, resp);
                break;
            case "Usuario-add":
                req.getRequestDispatcher("Usuario-add.jsp").forward(req, resp);
                break;
            case "Usuario-eli":
                req.getRequestDispatcher("Usuario-eli.jsp").forward(req, resp);
                break;
            case "Usuario-modificar":
                req.getRequestDispatcher("Usuario-modificar.jsp").forward(req, resp);
                break;
            case "abrirForm":
                abrirForm(req, resp);
                break;
            case "listar":
                listar(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String accion = req.getParameter("accion");
        System.out.println("accion");
        switch (accion) {
            case "add":
                // nombre_Usua = req.getParameter("Nombre_Usua");
                add(req, resp);
                break;
            case "modificar":
                modificar(req, resp);
                break;

            case "login":
                String username = req.getParameter("username");
                String password = req.getParameter("password");

                if (username.equals("karen") && password.equals("12")) {
                    // Usuario y contraseña válidos
                    req.getRequestDispatcher("menu.jsp").forward(req, resp);
                } else {
                    // Usuario o contraseña inválidos
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
                break;

            case "Daviplata":
                String usernamer = req.getParameter("username");
                String passwordr = req.getParameter("password");

                if (usernamer.equals("karen") && passwordr.equals("122")) {
                    // Usuario y contraseña válidos
                    req.getRequestDispatcher("Daviplata.jsp").forward(req, resp);
                } else {
                    // Usuario o contraseña inválidos
                    req.getRequestDispatcher("Daviplataa.jsp").forward(req, resp);
                }
                break;

            case "Nequi":
                String usernamerr = req.getParameter("username");
                String passwordrr = req.getParameter("password");

                if (usernamerr.equals("karen") && passwordrr.equals("1223")) {
                    // Usuario y contraseña válidos
                    req.getRequestDispatcher("Nequi.jsp").forward(req, resp);
                } else {
                    // Usuario o contraseña inválidos
                    req.getRequestDispatcher("Nequii.jsp").forward(req, resp);
                }
                break;

        }
    }

    private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("Usuario-add.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        } catch (Exception e) {
            System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        r = new UsuariosVo();

        String id_Usuarios = "";
        String nombre_Usua = req.getParameter("Nombre_Usua");
        String apellido_Usua = req.getParameter("apellido_Usua");
        String telefono_Usua = req.getParameter("Telefono_Usua");
        String correo_Usua = req.getParameter("Correo_Usua");
        String password = req.getParameter("password_u");
        System.out.println("La contraseña recibida afuera del if fue " + password);
        boolean Estado_Usua = false;
        if (nombre_Usua != null) {
            r.setNombre_Usua(req.getParameter("Nombre_Usua"));
        }
        if (apellido_Usua != null) {
            r.setApellido_Usua(req.getParameter("apellido_Usua"));
        }
        if (telefono_Usua != null) {
            int telefono = Integer.parseInt(telefono_Usua);
            r.setTelefono_Usua(telefono);
        }
        if (correo_Usua != null) {
            r.setCorreo_Usua(req.getParameter("Correo_Usua"));
        }
        if (password != null) {
            int i_password = Integer.parseInt(password);
            r.setContraseña_Usua(i_password);
            System.out.println("La contraseña recibida dentro del if fue " + password);
        }
        if (req.getParameter("Estado_Usua") != null) {
            r.setEstado_Usua(true);
        } else {
            r.setEstado_Usua(false);
        }
        try {
            rd.registrar(r);
            // sys
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }

    }

    private void modificar(HttpServletRequest req, HttpServletResponse resp) {
        r = new UsuariosVo();

        String nombre_Usua = req.getParameter("Nombre_Usua");
        String apellido_Usua = req.getParameter("apellido_Usua");
        String telefono_Usua = req.getParameter("Telefono_Usua");
        String correo_Usua = req.getParameter("Correo_Usua");
        String password = req.getParameter("password_u");
        String id_Usuarios = req.getParameter("Id_Usuarios");
        System.out.println("La contraseña recibida afuera del if fue " + password);
        boolean estado_Usua = false;
        if (nombre_Usua != null) {
            r.setNombre_Usua(req.getParameter("Nombre_Usua"));
        }
        if (apellido_Usua != null) {
            r.setApellido_Usua(req.getParameter("apellido_Usua"));
        }
        if (telefono_Usua != null) {
            int telefono = Integer.parseInt(telefono_Usua);
            r.setTelefono_Usua(telefono);
        }
        if (correo_Usua != null) {
            r.setCorreo_Usua(req.getParameter("Correo_Usua"));
        }
        if (password != null) {
            int i_password = Integer.parseInt(password);
            r.setContraseña_Usua(i_password);
            System.out.println("La contraseña recibida dentro del if fue " + password);
        }
        if (req.getParameter("Estado_Usua") != null) {
            r.setEstado_Usua(true);
        } else {
            r.setEstado_Usua(false);
        }
        if (id_Usuarios != null) {
            int Usuarios = Integer.parseInt(id_Usuarios);
            r.setTelefono_Usua(Usuarios);
        }
        try {
            req.getRequestDispatcher("Usuario-modificar.jsp").forward(req, resp);
            rd.modificar(r);

            // sys
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }

    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List Usuarios = rd.listar();
            req.setAttribute("Usuarios", Usuarios);
            req.getRequestDispatcher("Usuarios.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

}
