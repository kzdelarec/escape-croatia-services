package hr.tvz.zdelarec.escapecroatioaservices.dto;

import java.util.List;

/**
 * InformationDto class.
 *
 * @author kristijan.zdelarec
 */
public class InformationDto {

    /**
     * Information DTO content type.
     */
    public static final String CONTENT_TYPE = "application/information.v1+json";

    private List<DeveloperDto> developerDtoList;
    private List<TesterDto> testerDtoList;
    private List<ContributorDto> contributorDtoList;

    public List<DeveloperDto> getDeveloperDtoList() {
        return developerDtoList;
    }

    public void setDeveloperDtoList(final List<DeveloperDto> developerDtoList) {
        this.developerDtoList = developerDtoList;
    }

    public List<TesterDto> getTesterDtoList() {
        return testerDtoList;
    }

    public void setTesterDtoList(final List<TesterDto> testerDtoList) {
        this.testerDtoList = testerDtoList;
    }

    public List<ContributorDto> getContributorDtoList() {
        return contributorDtoList;
    }

    public void setContributorDtoList(final List<ContributorDto> contributorDtoList) {
        this.contributorDtoList = contributorDtoList;
    }

    @Override
    public String toString() {
        return "ContributorDto{" +
                "developerDtoList=" + developerDtoList +
                ", testerDtoList=" + testerDtoList +
                ", contributorDtoList=" + contributorDtoList +
                '}';
    }
}
