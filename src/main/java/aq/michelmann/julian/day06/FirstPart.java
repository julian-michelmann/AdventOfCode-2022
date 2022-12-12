package aq.michelmann.julian.day06;

public class FirstPart {
    
    CommunicationSystem communicationSystem = new CommunicationSystem();
    
    public Integer solve(String dataStream) {
        return communicationSystem.findEndOfFirstMarkerAsIndex(dataStream);
    }
}
