package Lsp;

class Instagram extends PostMediaManager {

    @Override
    void chat() {
        System.out.println("Mengirim pesan via Instagram DM...");
    }

    @Override
    void sendPhotosAndVideos() {
        System.out.println("Mengirim foto/video story atau DM di Instagram...");
    }

    @Override
    void publishPost() {
        System.out.println("Mempublikasikan post baru di Instagram...");
    }
}
