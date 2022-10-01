package serveur.videoservice;

public class MovieDescExtended extends MovieDesc {

   // private String synopsis; Pas besoin d'un 2e si ?

    private byte[] teaser;

    public MovieDescExtended(String movieName, String isbn, String synopsis) {
        super(movieName, isbn, synopsis);
    }

    public void setTeaser(byte[] teaser) {
        this.teaser = teaser;
    }

    public byte[] getTeaser() {
        return teaser;
    }
}