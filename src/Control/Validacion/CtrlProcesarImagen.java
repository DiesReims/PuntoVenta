package Control.Validacion;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlProcesarImagen {

    //Encargado de recibir array de bits de BD para pasarlos a Image
    public Image ConvertirImagen(byte[] bytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            Iterator readers = ImageIO.getImageReadersByFormatName("jpeg");
            ImageReader reader = (ImageReader) readers.next();
            Object source = bis;
            ImageInputStream iis = ImageIO.createImageInputStream(source);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            return reader.read(0, param);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return null;
        }

    }

}
