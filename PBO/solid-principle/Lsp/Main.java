package Lsp;


public class Main {
    public static void main(String[] args) {

        SocialMedia wa = new WhatsApp();
        SocialMedia ig = new Instagram();

        System.out.println("=== WhatsApp ===");
        wa.chat();
        wa.sendPhotosAndVideos();
        if (wa instanceof VideoGroupManager) {
            ((VideoGroupManager) wa).callGroupVideo();
        }

        System.out.println("\n=== Instagram ===");
        ig.chat();
        ig.sendPhotosAndVideos();
        if (ig instanceof PostMediaManager) {
            ((PostMediaManager) ig).publishPost();
        }
    }
}

