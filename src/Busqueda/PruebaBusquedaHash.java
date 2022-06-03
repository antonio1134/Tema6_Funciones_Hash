package Busqueda;
import MetodoHash.TablaHash;
import javax.swing.JOptionPane;
public class PruebaBusquedaHash {
    public static void main(String[] args) {
        try {
        int i,num_pro,precio=0,opc;
        String nombre_pro="";
        int m = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño del inventario: "));
            TablaHash[] h = new TablaHash[m];
            for (i = 0; i < m; i++) {
                h[i] = new TablaHash();
                h[i].estado = 0;
            }
            do{
               opc = Integer.parseInt(JOptionPane.showInputDialog("-- INVENTARIO --\n"
                       +"(1)Insertar\n(2)Buscar\n(3)Eliminar\n(4)Mostrar\n\t(5)Salir"));

               switch(opc){
                   case 1: num_pro = Integer.parseInt(JOptionPane.showInputDialog(
                           "Ingrese el código del producto"));
                        nombre_pro = JOptionPane.showInputDialog("Nombre del producto");
                        precio = Integer.parseInt(JOptionPane.showInputDialog(
                           "Digita el precio del producto"));
                            TablaHash.insertaHash(h, m,num_pro,nombre_pro,precio);
                            break;
                   case 2:num_pro = Integer.parseInt(JOptionPane.showInputDialog(
                           "Ingrese el código del producto a buscar en el inevtario"));
                        i = TablaHash.buscaHash(h, m, num_pro);
                        if(i == -1){
                            JOptionPane.showMessageDialog(null,"Número no encontrado ","Inventario ",
                                    JOptionPane.ERROR);
                        }else{
                            JOptionPane.showMessageDialog(null,"Número encontrado ","Inventario ",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                            break;
                   case 3:num_pro = Integer.parseInt(JOptionPane.showInputDialog(
                           "Ingresa el código del producto que desea eliminar"));
                   i = TablaHash.eliminaHash(h, m, num_pro);
                        if(i == -1){
                            JOptionPane.showMessageDialog(null,"Número no encontrado ","Inventario ",
                                    JOptionPane.ERROR);
                        }else{
                            JOptionPane.showMessageDialog(null,"Número eliminado con éxito ","Inventario ",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                            break;
                   case 4:TablaHash.Mostrar(h);
                            break;
               }
            }while(opc != 5);
             } catch(NumberFormatException nfe) {
                javax.swing.JOptionPane.showMessageDialog(null, "Está Saliendo del Programa... ");
            } catch (OutOfMemoryError ome) {
                javax.swing.JOptionPane.showMessageDialog(null, "No Hay Espacio ");
            }
        }
    }   

