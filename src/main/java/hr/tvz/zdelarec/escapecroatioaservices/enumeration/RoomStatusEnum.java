package hr.tvz.zdelarec.escapecroatioaservices.enumeration;

/**
 * Room status enums.
 *
 * @author kristijan.zdelarec
 */
public enum RoomStatusEnum {
    /**
     * Not played enum.
     */
    NOT_PLAYED(0, "Not played"),

    /**
     * Game lost enum.
     */
    GAME_LOST(1, "Game lost"),

    /**
     * Game won enum.
     */
    GAME_WON(2, "Game won");

    /**
     * Enum index.
     */
    private int index;

    /**
     * Enum value.
     */
    private String value;


    /**
     * {@link RoomStatusEnum} constructor.
     *
     * @param index enum index
     * @param value enum value
     */
    RoomStatusEnum(final int index, final String value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Method for getting enum via value.
     *
     * @param index enum value
     * @return {@link RoomStatusEnum}
     */
    public static RoomStatusEnum getContributionType(final int index) {
        for (final RoomStatusEnum roomStatus : values()) {
            if (roomStatus.index == index) {
                return roomStatus;
            }
        }
        throw new IllegalArgumentException("No enum type with value " + index + " found!");
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
