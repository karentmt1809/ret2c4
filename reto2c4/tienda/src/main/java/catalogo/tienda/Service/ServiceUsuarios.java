package catalogo.tienda.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import catalogo.tienda.Model.Usuarios;
import catalogo.tienda.Repository.RepositoryUsuarios;

/**
 *
 * @author karent_saenz
 */
@Service
public class ServiceUsuarios {

    /**
     * Objeto de tipo repositoritorioUsuarios 
     */
    @Autowired
    private RepositoryUsuarios mCrUsuarios;

    /**
     * metodo para poder tener la informacion  de los usuarios
     *
     * @return List de clase Usuarios
     */
    public List<Usuarios> getAll() {
        return mCrUsuarios.getAll();
    }

    /**
     * metodo para tener infprmacion dependiendo del id referemciado
     *
     * @param idUser
     * @return Optional de clase Usuarios
     */
    public Optional<Usuarios> getUser(int idUser) {
        return mCrUsuarios.getUser(idUser);
    }

    /**
     * metodo para guardar  la informacion de los usurios
     *
     * @param user
     * @return valor de calse Usuarios
     */
    public Usuarios save(Usuarios user) {
        if (user.getId() == null) {
            return mCrUsuarios.save(user);
        } else {
            /**
             * Atributo de tipo optional
             */
            Optional<Usuarios> evento = mCrUsuarios.getUser(user.getId());
            if (evento.isEmpty()) {
                return mCrUsuarios.save(user);
            } else {
                return user;
            }
        }
    }

    /**
     * metodo para actualizar informacion de los usuarios
     *
     * @param user
     * @return valor de calse Usuarios
     */
    public Usuarios update(Usuarios user) {
        if (user.getId() != null) {
            /**
             * Atributo de tipo optional
             */
            Optional<Usuarios> evento = mCrUsuarios.getUser(user.getId());
            if (!evento.isEmpty()) {
                if (user.getIdentification() != null) {
                    evento.get().setIdentification(user.getIdentification());
                }

                if (user.getName() != null) {
                    evento.get().setName(user.getName());
                }

                if (user.getAddress() != null) {
                    evento.get().setAddress(user.getAddress());
                }

                if (user.getCellPhone() != null) {
                    evento.get().setCellPhone(user.getCellPhone());
                }

                if (user.getEmail() != null) {
                    evento.get().setEmail(user.getEmail());
                }

                if (user.getPassword() != null) {
                    evento.get().setPassword(user.getPassword());
                }

                if (user.getZone() != null) {
                    evento.get().setZone(user.getZone());
                }

                if (user.getType() != null) {
                    evento.get().setType(user.getType());
                }
            }

            return mCrUsuarios.save(evento.get());
        }
        return user;
    }

    /**
     * metodo para borrar un usuario por su id
     *
     * @param idUser
     * @return boolean
     */
    public boolean delete(int idUser) {
        /**
         * Atributo de tipo optional
         */
        Optional<Usuarios> evento = mCrUsuarios.getUser(idUser);
        if (!evento.isEmpty()) {
            mCrUsuarios.delete(idUser);
            return true;
        }

        return false;
    }

    /**
     * Metodo para saber si existe o no un usuario
     *
     * @param email
     * @return boolean
     */
    public boolean getUserEmail(String email){
        /**
         * Atributo de tipo optional
         */
        Optional<Usuarios> evento = mCrUsuarios.getUserByEmail(email);
        return !evento.isEmpty();
    }

    /**
     * metodo para reporte de Usuarios
     *
     * @param email
     * @param password
     * @return boolean
     */
    public Optional<Usuarios> getUserEmailPass(String email, String password){
        /**
         * Atributo de tipo optional
         */
        Optional<Usuarios> evento = mCrUsuarios.getUserEmailPass(email, password);
        if(!evento.isEmpty()){
            return mCrUsuarios.getUserEmailPass(email, password);
        }else{
            Usuarios usuario = new Usuarios();
            usuario.setId(null);
            usuario.setIdentification(null);
            usuario.setName(null);
            usuario.setAddress(null);
            usuario.setCellPhone(null);
            usuario.setEmail(null);
            usuario.setPassword(null);
            usuario.setZone(null);
            usuario.setType(null);
            /**
             * Atributo de tipo optional
             */
            Optional<Usuarios> evento1 = Optional.of(usuario);
            
            return evento1;
        }
    }
}

