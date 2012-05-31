/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package webservice;

/**
 *
 * @author gcasillascos
 */
public class ClienteMasivo {



        private int cliId;
        private int cliSap;
        private int genero;
        private int estadoCivil;
        private int tipoResidencia;
        private int dependientes;
        private int ingresos;
        private int edad;
        private int tiempoResidencia;
        private int antiguedad;
        private int dineroExtra;
        private int gastoProximo;
        private int nivelEscolar;
        private int actExtra;
        private int prestamo;
        private int religion;
        private int influenciaReligion;
        private int asociacionPartido;
        private int partidoPol;
        private int indOpinionBarzon;
        private int migracion;
        private int tieneCredito;
        private int mesVencido;
        private int pcPago;
        private int pcUso;



        private double generoClase;
        private double comportamientoPago;
        private double arraigo;
        private double aspectosDiferenciadores;
        private String primerTextoGenero;
        private String segundoTextoGenero;
        private String primerTextoComportamiento;
        private String segundoTextoComportamiento;
        private String primerTextoArraigo;
        private String segundoTextoArraigo;
        private String primerTextoDiferenciadores;
        private String segundoTextoDiferenciadores;
        private String resultado;




        public ClienteMasivo()
        {
        }

        public ClienteMasivo(int acliId,int acliSap,int agenero,int aestadoCivil,int atipoResidencia,
                int adependientes,int aingresos,int aedad,int atiempoResidencia,int aantiguedad,int adineroExtra,
                int agastoProximo,int anivelEscolar,int aactExtra,int aprestamo,int areligion,int ainfluenciaReligion,int aasociacionPartido,
                int apartidoPol,int aindOpinionBarzon,int amigracion,int atieneCredito,int amesVencido,int apcPago,int apcUso)
                {
                    cliId = acliId;
                    cliSap = acliSap;
                    genero = agenero;
                    estadoCivil = aestadoCivil;
                    tipoResidencia = atipoResidencia;
                    dependientes = adependientes;
                    ingresos = aingresos;
                    edad = aedad;
                    tiempoResidencia = atiempoResidencia;
                    antiguedad = aantiguedad;
                    dineroExtra = adineroExtra;
                    gastoProximo = agastoProximo;
                    nivelEscolar = anivelEscolar;
                    actExtra = aactExtra;
                    prestamo = aprestamo;
                    religion = areligion;
                    influenciaReligion = ainfluenciaReligion;
                    asociacionPartido = aasociacionPartido;
                    partidoPol = apartidoPol;
                    indOpinionBarzon = aindOpinionBarzon;
                    migracion = amigracion;
                    tieneCredito = atieneCredito;
                    mesVencido = amesVencido;
                    pcPago = apcPago;
                    pcUso = apcUso;

                }


    public int getActExtra() {
        return actExtra;
    }

    public void setActExtra(int actExtra) {
        this.actExtra = actExtra;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getAsociacionPartido() {
        return asociacionPartido;
    }

    public void setAsociacionPartido(int asociacionPartido) {
        this.asociacionPartido = asociacionPartido;
    }

    public int getCliId() {
        return cliId;
    }

    public void setCliId(int cliId) {
        this.cliId = cliId;
    }

    public int getCliSap() {
        return cliSap;
    }

    public void setCliSap(int cliSap) {
        this.cliSap = cliSap;
    }

    public int getDependientes() {
        return dependientes;
    }

    public void setDependientes(int dependientes) {
        this.dependientes = dependientes;
    }

    public int getDineroExtra() {
        return dineroExtra;
    }

    public void setDineroExtra(int dineroExtra) {
        this.dineroExtra = dineroExtra;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getGastoProximo() {
        return gastoProximo;
    }

    public void setGastoProximo(int gastoProximo) {
        this.gastoProximo = gastoProximo;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getIndOpinionBarzon() {
        return indOpinionBarzon;
    }

    public void setIndOpinionBarzon(int indOpinionBarzon) {
        this.indOpinionBarzon = indOpinionBarzon;
    }

    public int getInfluenciaReligion() {
        return influenciaReligion;
    }

    public void setInfluenciaReligion(int influenciaReligion) {
        this.influenciaReligion = influenciaReligion;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getMesVencido() {
        return mesVencido;
    }

    public void setMesVencido(int mesVencido) {
        this.mesVencido = mesVencido;
    }

    public int getMigracion() {
        return migracion;
    }

    public void setMigracion(int migracion) {
        this.migracion = migracion;
    }

    public int getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(int nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public int getPartidoPol() {
        return partidoPol;
    }

    public void setPartidoPol(int partidoPol) {
        this.partidoPol = partidoPol;
    }

    public int getPcPago() {
        return pcPago;
    }

    public void setPcPago(int pcPago) {
        this.pcPago = pcPago;
    }

    public int getPcUso() {
        return pcUso;
    }

    public void setPcUso(int pcUso) {
        this.pcUso = pcUso;
    }

    public int getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(int prestamo) {
        this.prestamo = prestamo;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getTiempoResidencia() {
        return tiempoResidencia;
    }

    public void setTiempoResidencia(int tiempoResidencia) {
        this.tiempoResidencia = tiempoResidencia;
    }

    public int getTieneCredito() {
        return tieneCredito;
    }

    public void setTieneCredito(int tieneCredito) {
        this.tieneCredito = tieneCredito;
    }

    public int getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(int tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }




    //Resultados


    public double getArraigo() {
        return arraigo;
    }

    public void setArraigo(double arraigo) {
        this.arraigo = arraigo;
    }

    public double getAspectosDiferenciadores() {
        return aspectosDiferenciadores;
    }

    public void setAspectosDiferenciadores(double aspectosDiferenciadores) {
        this.aspectosDiferenciadores = aspectosDiferenciadores;
    }

    public double getComportamientoPago() {
        return comportamientoPago;
    }

    public void setComportamientoPago(double comportamientoPago) {
        this.comportamientoPago = comportamientoPago;
    }

    public double getGeneroClase() {
        return generoClase;
    }

    public void setGeneroClase(double generoClase) {
        this.generoClase = generoClase;
    }


    public String getPrimerTextoArraigo() {
        return primerTextoArraigo;
    }

    public void setPrimerTextoArraigo(String primerTextoArraigo) {
        this.primerTextoArraigo = primerTextoArraigo;
    }

    public String getPrimerTextoComportamiento() {
        return primerTextoComportamiento;
    }

    public void setPrimerTextoComportamiento(String primerTextoComportamiento) {
        this.primerTextoComportamiento = primerTextoComportamiento;
    }

    public String getPrimerTextoDiferenciadores() {
        return primerTextoDiferenciadores;
    }

    public void setPrimerTextoDiferenciadores(String primerTextoDiferenciadores) {
        this.primerTextoDiferenciadores = primerTextoDiferenciadores;
    }

    public String getPrimerTextoGenero() {
        return primerTextoGenero;
    }

    public void setPrimerTextoGenero(String primerTextoGenero) {
        this.primerTextoGenero = primerTextoGenero;
    }

    public String getSegundoTextoArraigo() {
        return segundoTextoArraigo;
    }

    public void setSegundoTextoArraigo(String segundoTextoArraigo) {
        this.segundoTextoArraigo = segundoTextoArraigo;
    }

    public String getSegundoTextoComportamiento() {
        return segundoTextoComportamiento;
    }

    public void setSegundoTextoComportamiento(String segundoTextoComportamiento) {
        this.segundoTextoComportamiento = segundoTextoComportamiento;
    }

    public String getSegundoTextoDiferenciadores() {
        return segundoTextoDiferenciadores;
    }

    public void setSegundoTextoDiferenciadores(String segundoTextoDiferenciadores) {
        this.segundoTextoDiferenciadores = segundoTextoDiferenciadores;
    }

    public String getSegundoTextoGenero() {
        return segundoTextoGenero;
    }

    public void setSegundoTextoGenero(String segundoTextoGenero) {
        this.segundoTextoGenero = segundoTextoGenero;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
