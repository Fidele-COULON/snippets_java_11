package fr.fidtec.concepts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// https://www.baeldung.com/java-deprecated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DeprecatedClass {

    /**
     * Simple Java DOC sans rien
     * @param : nothing
     * @return past year
     */
    @Deprecated
    public static String getYearV1() {
        return "2024";
    }

    /**
     * Simple Java DOC avec @deprecated
     * @deprecated Version2
     * Ligne 2
     * @param : nothing
     * @return past year
     */
    @Deprecated
    public static String getYearV2() {
        return "2024";
    }

    /**
     * Simple Java DOC @deprecated
     * @deprecated
     * Version3
     * Ligne 2
     * @param : nothing
     * @return past year
     */
    @Deprecated
    public static String getYearv3() {
        return "2024";
    }

    /**
     * Simple Java DOC @Deprecated
     * @Deprecated
     * Version4
     * Ligne 2
     * @param : nothing
     * @return past year
     */
    @Deprecated
    public static String getYearv4() {
        return "2024";
    }

    /**
     * Simple Java DOC since
     * @deprecated
     * Version5
     * Ligne 2
     * @param : nothing
     * @return past year
     */
    @Deprecated(since = "2.0")
    public static String getYearv5() {
        return "2024";
    }

    /**
     * Simple Java DOC since +     @Deprecated(since = "2.0", forRemoval = true)
     * @deprecated
     * Version6
     * Ligne 2
     * @param : nothing
     * @return past year
     */
    @Deprecated(since = "2.0", forRemoval = true)
    public static String getYearv6() {
        return "2024";
    }

    /**
     * Simple Java DOC external annotation with IntelliJ
     * https://stackoverflow.com/questions/55576840/deprecating-a-variable-in-an-external-library-interface
     * https://www.jetbrains.com/help/idea/annotating-source-code.html#external-annotations
     * @param : nothing
     * @return past year
     */
    @Deprecated
    public static String getYearv7() {
        return "2024";
    }

}
