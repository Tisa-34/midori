package Lsp;


class WhatsApp extends VideoGroupManager {

    @Override
    void chat() {
        System.out.println("Mengirim pesan via WhatsApp...");
    }

    @Override
    void sendPhotosAndVideos() {
        System.out.println("Mengirim foto dan video di WhatsApp...");
    }

    @Override
    void callGroupVideo() {
        System.out.println("Melakukan panggilan video grup di WhatsApp...");
    }
}
