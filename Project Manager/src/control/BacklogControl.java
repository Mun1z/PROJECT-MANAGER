
package control;

import database.ConectaDB;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Backlog;
import model.Usuario;

/**
 *
 * @author Raiff
 */
public class BacklogControl {
    
    private static BacklogControl controladorBacklog;
    
    //singleton
    public static BacklogControl getInstance(){
        if(controladorBacklog == null){
            controladorBacklog = new BacklogControl();
            return controladorBacklog;
        }
        return controladorBacklog;
    }
    
    /**
     * Método responsávem por cadastrar um backlog no banco de dados.
     * O método recebe como parametro um objeto do tipo Usuario.
     * @author Felipe Muniz
     * @param backlog
     * @return boolean
     */
    public static boolean cadastrarBacklog(Backlog backlog){
        
        ConectaDB conecta = new ConectaDB();
        conecta.conexao();
        
        String sql = "INSERT INTO backlog() VALUES(?,?,?)";
        
        try {
            PreparedStatement pst = conecta.conn.prepareStatement(sql);
            pst.setString(1, null);
            pst.setString(2, backlog.getDataDeCriacao().toString());
            pst.setString(3, backlog.getDataUltimaModificacao().toString());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(BacklogControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Conectar! \n Erro: " + ex.getMessage());
        }
        conecta.desconecta();
        return true;
    }
    
    public void deletarBacklog(){
    
    }
    
    public void editarBacklog(){
    
    }
    
    public void listarBacklog(){
    
    }
}
