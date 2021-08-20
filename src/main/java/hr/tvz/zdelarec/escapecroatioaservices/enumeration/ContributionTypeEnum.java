package hr.tvz.zdelarec.escapecroatioaservices.enumeration;

/**
 * Contribution type enums.
 *
 * @author kristijan.zdelarec
 */
public enum ContributionTypeEnum {
    /**
     * Icons enum.
     */
    ICON(0, "Icons"),

    /**
     * Animations enum.
     */
    ANIMATION(1, "Animations"),

    /**
     * Data enum.
     */
    DATA(2, "Data");

    /**
     * Enum index.
     */
    private int index;

    /**
     * Enum value.
     */
    private String value;


    /**
     * {@link ContributionTypeEnum} constructor.
     *
     * @param index enum index
     * @param value enum value
     */
    ContributionTypeEnum(final int index, final String value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Method for getting enum via value.
     *
     * @param index enum value
     * @return {@link ContributionTypeEnum}
     */
    public static ContributionTypeEnum getContributionType(final int index) {
        for (final ContributionTypeEnum contributionType : values()) {
            if (contributionType.index == index) {
                return contributionType;
            }
        }
        throw new IllegalArgumentException("No industry type with value " + index + " found!");
    }

    /**
     * Get enum index.
     * @return enum index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get enum value.
     * @return enum value
     */
    public String getValue() {
        return value;
    }
}
