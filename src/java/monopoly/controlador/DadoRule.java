/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly.controlador;


/**
 *
 * @author Rodrigo
 */
public class DadoRule {
    int numero;
    String imagen;
    
    /**
     *
     */
    public DadoRule() {
    }

    /**
     *
     * @param numero
     * @param imagen
     */
    public DadoRule(int numero, String imagen) {
        this.numero = numero;
        this.imagen=imagen;
    }

    /**
     *
     * @return
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public String getImagen() {
        return imagen;
    }

    /**
     *
     * @param imagen
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     *
     * @param result
     * @return
     */
    public DadoRule resultadoDado(int result){
        String tipoFichero=".gif";
        DadoRule dado = new DadoRule();
        switch(result){
                case 1:
                    dado.setImagen("Dice1"+tipoFichero);
                    dado.setNumero(result); 
                    break;
                case 2:
                    dado.setImagen("Dice2"+tipoFichero);
                    dado.setNumero(result); 
                    break;
                case 3:
                    dado.setImagen("Dice3"+tipoFichero);
                    dado.setNumero(result); 
                    break;
                case 4:
                    dado.setImagen("Dice4"+tipoFichero);
                    dado.setNumero(result); 
                    break;
                case 5:
                    dado.setImagen("Dice5"+tipoFichero);
                    dado.setNumero(result); 
                    break;
                case 6:
                    dado.setImagen("Dice6"+tipoFichero);
                    dado.setNumero(result); 
                    break;                
                default:
                    dado.setImagen("Dice1"+tipoFichero);
                    dado.setNumero(1);
                    break;
            }
        return dado;
    }
    
    
}
