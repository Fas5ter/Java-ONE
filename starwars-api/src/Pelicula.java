public record Pelicula(String title,
                       int episode_id,
                       String opening_crawl,
                       String director,
                       String producer,
                       String release_date) {
    @Override
    public String toString() {
        return "(nombre=" + this.title +
                ", episode_id=" + this.episode_id +
                ", opening_crawl=" + this.opening_crawl +
                ", director=" + this.director +
                ", producer=" + this.producer +
                ", release_date=" + this.release_date + ")";
    }
}
