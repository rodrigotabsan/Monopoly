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
     * @param numero el resultado del random del Dado
     * @param imagen la imagen del dado
     */
    public DadoRule(int numero, String imagen) {
        this.numero = numero;
        this.imagen=imagen;
    }

    /**
     *
     * @return el resultado del dado
     */
    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero resultado del random del dado.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return la imagen del dado
     */
    public String getImagen() {
        return imagen;
    }

    /**
     *
     * @param imagen la imagen del dado
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     *
     * @param result resultado del dado
     * @return el Dado
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
