package models;

public class UsuariosVo {
    private int id_Usuarios;
    private String nombre_Usua;
    private String apellido_Usua;
    private int telefono_Usua;
    private String correo_Usua;
    private int contraseña_Usua;
    private boolean estado_Usua;
    
   


    public UsuariosVo() {
    }




    public UsuariosVo(int id_Usuarios, String nombre_Usua, String apellido_Usua, int telefono_Usua, String correo_Usua,
            int contraseña_Usua, boolean estado_Usua) {
        this.id_Usuarios = id_Usuarios;
        this.nombre_Usua = nombre_Usua;
        this.apellido_Usua = apellido_Usua;
        this.telefono_Usua = telefono_Usua;
        this.correo_Usua = correo_Usua;
        this.contraseña_Usua = contraseña_Usua;
        this.estado_Usua = estado_Usua;
    }




    public int getId_Usuarios() {
        return id_Usuarios;
    }




    public void setId_Usuarios(int id_Usuarios) {
        this.id_Usuarios = id_Usuarios;
    }




    public String getNombre_Usua() {
        return nombre_Usua;
    }




    public void setNombre_Usua(String nombre_Usua) {
        this.nombre_Usua = nombre_Usua;
    }




    public String getApellido_Usua() {
        return apellido_Usua;
    }




    public void setApellido_Usua(String apellido_Usua) {
        this.apellido_Usua = apellido_Usua;
    }




    public int getTelefono_Usua() {
        return telefono_Usua;
    }




    public void setTelefono_Usua(int telefono_Usua) {
        this.telefono_Usua = telefono_Usua;
    }




    public String getCorreo_Usua() {
        return correo_Usua;
    }




    public void setCorreo_Usua(String correo_Usua) {
        this.correo_Usua = correo_Usua;
    }




    public int getContraseña_Usua() {
        return contraseña_Usua;
    }




    public void setContraseña_Usua(int contraseña_Usua) {
        this.contraseña_Usua = contraseña_Usua;
    }




    public boolean getEstado_Usua() {
        return estado_Usua;
    }




    public void setEstado_Usua(boolean estado_Usua) {
        this.estado_Usua = estado_Usua;
    }




 
}