class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {

        super(title, publicationYear);

        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        System.out.println("Book : " + title);
        System.out.println("Publication Year : " + publicationYear);
        System.out.println("Author : " + name);
        System.out.println("Bio : " + bio);
    }
}