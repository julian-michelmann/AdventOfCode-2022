package aq.michelmann.julian.day06;

public class SecondPart {
    
    CommunicationSystem communicationSystem = new CommunicationSystem();
    
    Integer solve(String dataStream) {
        return communicationSystem.findEndOfFirstMessageAsIndex(dataStream);
    }
}
