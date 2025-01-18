package fr.fidtec.mappers;

import fr.fidtec.beans.UserBeanDest;
import fr.fidtec.beans.UserBeanSource;
import fr.fidtec.enums.MrMme_FR;
import fr.fidtec.enums.MrMme_US;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // https://www.tutorialspoint.com/mapstruct/mapstruct_using_defaultvalue.htm
    // default-value − target-property will be set as default-value in case source-property is null.
    @Mapping(target = "nom", source = "lastName", defaultValue = "")
    @Mapping(target = "prenom", source = "firstName", defaultValue = "")
    @Mapping(target = "genre", expression = "java(convertGenderToGenre(source.getGender()))")
    UserBeanDest userBeanSourceToUserBeanDest(UserBeanSource source);

    default MrMme_FR convertGenderToGenre(MrMme_US gender) {
        if (gender == MrMme_US.Sir) {
            return MrMme_FR.Monsieur;
        } else if (gender == MrMme_US.Madam) {
            return MrMme_FR.Madame;
        } else if (gender == MrMme_US.Miss) {
            return MrMme_FR.Mademoiselle;
        } else {
            return null;
        }
    }
}
