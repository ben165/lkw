package org.truck.serviceCenter;

public class EngineTeam extends Team implements ICategory{
    public EngineTeam(){
        super();
    }

    @Override
    public TeamManager getManagerByCategory(String category) {
        if (category.equals("E01") || category.equals("E02")) {
            return operationTeamManager;
        } else if (category.equals("E03")) {
            return emergencyTeamManager;
        }
        return null;
    }
}
