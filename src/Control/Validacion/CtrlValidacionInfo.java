package Control.Validacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Diego Alberto Zárate Lara
 */
public class CtrlValidacionInfo {

    //<editor-fold defaultstate="collapsed" desc="MTD Validación General">
    public boolean validacionGeneral(String _cadena, int _longitudMax, int _longitudMin) {
        try {
            if (!this.validacionNoNulo(_cadena)) {
                return false;
            }
            if (!this.validaLongitudMaxima(_cadena, _longitudMax)) {
                return false;
            }
            if (!this.validacionLongitudMinima(_cadena, _longitudMin)) {
                return false;
            }
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Valida No Nulo">
    public boolean validacionNoNulo(String _cadena) {
        try {
            return (_cadena.trim().length() > 0);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Valida Longitud Maxima">
    public boolean validaLongitudMaxima(String _cadena, int _longitudMax) {
        try {
            return (_cadena.trim().length() <= _longitudMax);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Valida Longitud Minima">
    public boolean validacionLongitudMinima(String _cadena, int _longitudMin) {
        try {
            return (_cadena.trim().length() >= _longitudMin);
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Validacion Caracteres No Permitidos">
    public boolean validacionNoCaracteres(String _cadena) {
        try {
            Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
            Matcher matcher = pattern.matcher(_cadena);
            if (!matcher.matches()) {
                return false;
            }
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Solo Numeros Decimales">
    public boolean SoloNumerosConPunto(String _cadena) {
        try {
            Pattern pattern = Pattern.compile("^[\\d]*[.]?[\\d]*$");
            Matcher matcher = pattern.matcher(_cadena);
            if (!matcher.matches()) {
                return false;
            }
            return true;
        } catch (Exception _e) {
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Solo Numeros">
    public boolean SoloNumeros(String _cadena) {
        try {
            Pattern pattern = Pattern.compile("^[\\d]*$");
            Matcher matcher = pattern.matcher(_cadena);
            if (!matcher.matches()) {
                return false;
            }
            return true;
        } catch (Exception _e) {
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Valida Correo">
    public boolean ValidaCorreo(String _cadena) {
        try {
            Pattern pattern = Pattern.compile("^[\\S]*[.]*[com]{1}[\\S]*$");
            Matcher matcher = pattern.matcher(_cadena);
            if (!matcher.matches()) {
                return false;
            }
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return false;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="MTD Valida Hora Registro proveedor">
    public boolean ValidaRegistro() {
        try {
            //1 = Domingo, 2 = Lunes
            int horaInicial = 9;
            int horaFinalNormal = 18;
            int horaFinalSabado = 14;
            int horaActual;
            Date date = new Date();
            int diaSemana;
            GregorianCalendar calendario = new GregorianCalendar();
            calendario.setTime(date);
            diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
            System.out.println("El dia de la semana es :" + diaSemana);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh");
            SimpleDateFormat simpleDateFormatTimeSection = new SimpleDateFormat("aa");
            horaActual = Integer.parseInt(simpleDateFormat.format(date));
            System.out.println("La hora actual es :" + horaActual);
            System.out.println("La hora esta en : " + simpleDateFormatTimeSection.format(date));
            String horarioSection = simpleDateFormatTimeSection.format(date);
            if (diaSemana > 1 && diaSemana < 7) {
                if ("AM".equals(horarioSection)) {
                    if (horaActual < 9) {
                        return false;
                    }
                } else {
                    if (horaActual > 6) {
                        return false;
                    }
                }
            } else if (diaSemana == 7) {
                if ("AM".equals(horarioSection)) {
                    if (horaActual < 9) {
                        return false;
                    }
                } else {
                    if (horaActual > 2) {
                        return false;
                    }
                }
            } else {
                System.out.println("Hoy es domingo, No se trabaja :3");
                return false;
            }
            return true;
        } catch (Exception _e) {
            System.out.println(_e.getMessage());
            _e.printStackTrace();
            return false;
        }
    }
//</editor-fold>

}
