public class Test {

    public static void main (String[] args) {

    Jwiki jwiki = new Jwiki("J. R. R. Tolkien"); 
    System.out.println("Title :"+jwiki.getDisplayTitle()); //get title
    System.out.println("Text : "+jwiki.getExtractText());  //get summary text
    // System.out.println("Image : "+jwiki.getImageURL());    //get image URL
    }
}