package dev.marcelohd.screen.music.model;

public enum TipoAlbum {


    album("album"),
    single ("single"),
    compilado("compilado");

    private String tipoAlbum;

    private TipoAlbum(String tipoAlbum) {
        this.tipoAlbum = tipoAlbum;
    }

    public static void mostraTodos(){
        for(TipoAlbum tipoAlbum :  TipoAlbum.values()){
            System.out.printf("%s ", tipoAlbum);
        }
    }


    public static TipoAlbum fromString(String busca){
        for (TipoAlbum tipoAlbum : TipoAlbum.values()) {
            if (tipoAlbum.tipoAlbum.equalsIgnoreCase(busca)) {
                return tipoAlbum;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + busca);
    }

}
