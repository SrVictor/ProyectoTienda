/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Computer
 */
public class GestionFicheros {

    public static void generarXML(String url) throws Exception {
        String name = "fichero.xml";
        ArrayList<Venta> ventas = Venta.getVentas();

        if (ventas.isEmpty()) {
            System.out.println("ERROR ArrayList vacio");
            return;
        } else {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, name, null);
            document.setXmlVersion("1.0");

            //Nodo principal
            Element raiz = document.getDocumentElement();
            //Por cada key creamos un item que contendrá la key y el value
            for (int i = 0; i < ventas.size(); i++) {

                Element itemNode = document.createElement("producto");

                Element idVenta = document.createElement("idVenta");
                Text tidVenta = document.createTextNode(String.valueOf(ventas.get(i).getIdVenta()));
                idVenta.appendChild(tidVenta);

                Element idArticulo = document.createElement("idArticulo");
                Text tidArticulo = document.createTextNode(String.valueOf(ventas.get(i).getIdArticulo()));
                idArticulo.appendChild(tidArticulo);

                Element nombre = document.createElement("nombre");
                Text tnombre = document.createTextNode(ventas.get(i).getNombre());
                nombre.appendChild(tnombre);

                Element fechaTransaccion = document.createElement("fechaTransaccion");
                Text tfechaTransaccion = document.createTextNode(ventas.get(i).getFechaTransaccion());
                fechaTransaccion.appendChild(tfechaTransaccion);

                Element cantidad = document.createElement("cantidad");
                Text tcantidad = document.createTextNode(String.valueOf(ventas.get(i).getCantidad()));
                cantidad.appendChild(tcantidad);

                Element precioTotal = document.createElement("precioTotal");
                Text tprecioTotal = document.createTextNode(String.valueOf(ventas.get(i).getIdVenta()));
                precioTotal.appendChild(tprecioTotal);

                itemNode.appendChild(idVenta);
                itemNode.appendChild(idArticulo);
                itemNode.appendChild(nombre);
                itemNode.appendChild(fechaTransaccion);
                itemNode.appendChild(cantidad);
                itemNode.appendChild(precioTotal);

                raiz.appendChild(itemNode); //pegamos el elemento a la raiz "Documento"
            }
            //Generate XML
            Source source = new DOMSource(document);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File(url)); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        }
    }

    public static int longitudTXT() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("productos.txt");
        BufferedReader br = new BufferedReader(fr);
        int o = 0;
        while ((br.readLine()) != null) {
            o++;
        }
        return o;
    }
    
    public static String[][] leerFicheroTexto(String ruta) throws FileNotFoundException, IOException, SQLException {
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        String[][] articuloss = new String[longitudTXT()][6];
        br.readLine();
        br.readLine();
        br.readLine();
        //lee la linea
        for (int i = 0; br.readLine() != null; i++) {
            String linea = br.readLine();
            linea = linea.trim();
            String[] datos = linea.trim().split("::");
            //convierte a String[][] la linea
            Articulo articulo = new Articulo();
            articulo.setNombre(datos[0]);
            articulo.setProductora(datos[1]);
            articulo.setClasificacion(datos[2]);
            articulo.setGenero(datos[3]);
            articulo.setStock(Integer.valueOf(datos[4]));
            articulo.setPrecio(Float.valueOf(datos[5]));       
            for (int u=0; u<datos.length;u++){
                articuloss[i][u]=datos[u];
            }
            AltaBajaArticulo.altaArticul(articulo);
        }

        br.close();
        return articuloss;
    }

}
