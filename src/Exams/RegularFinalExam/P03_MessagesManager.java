package Module02_Fundamentals.Exams.RegularFinalExam;
import java.util.*;

public class P03_MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        Map<String, User> users = new LinkedHashMap<>();
        List<User> orderedUsers = new ArrayList<>();

        String input;
        while (!(input = scanner.nextLine()).equals("Statistics")) {
            String[] tokens = input.split("=");
            String command = tokens[0];
            String username;

            if ("Add".equals(command)) {
                username = tokens[1];
                int sent = Integer.parseInt(tokens[2]);
                int received = Integer.parseInt(tokens[3]);

                if (!users.containsKey(username)) {
                    User newUser = new User(username, sent, received);
                    users.put(username, newUser);
                    orderedUsers.add(newUser);
                }
            } else if ("Message".equals(command)) {
                String sender = tokens[1];
                String receiver = tokens[2];

                User senderUser = users.get(sender);
                User receiverUser = users.get(receiver);

                if (senderUser != null && receiverUser != null) {
                    senderUser.send();
                    receiverUser.receive();

                    if (senderUser.getTotalMessages() >= capacity) {
                        System.out.println(sender + " reached the capacity!");
                        users.remove(sender);
                        orderedUsers.remove(senderUser);
                    }
                    if (receiverUser.getTotalMessages() >= capacity) {
                        System.out.println(receiver + " reached the capacity!");
                        users.remove(receiver);
                        orderedUsers.remove(receiverUser);
                    }
                }
            } else if ("Empty".equals(command)) {
                username = tokens[1];
                if ("All".equals(username)) {
                    users.clear();
                    orderedUsers.clear();
                } else {
                    users.remove(username);
                    orderedUsers.removeIf(user -> user.getUsername().equals(username));
                }
            }
        }

        System.out.println("Users count: " + orderedUsers.size());
        for (User user : orderedUsers) {
            System.out.println(user.getUsername() + " - " + user.getTotalMessages());
        }
    }

    static class User {
        private final String username;
        private int sent;
        private int received;

        public User(String username, int sent, int received) {
            this.username = username;
            this.sent = sent;
            this.received = received;
        }

        public String getUsername() {
            return username;
        }

        public void send() {
            sent++;
        }

        public void receive() {
            received++;
        }

        public int getTotalMessages() {
            return sent + received;
        }
    }
}
