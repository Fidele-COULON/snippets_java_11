package fr.fidtec.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import fr.fidtec.beans.DateStringBeanDest;
import fr.fidtec.beans.DateStringBeanSource;

@Mapper
public interface DateMapper {
	
	DateMapper INSTANCE = Mappers.getMapper(DateMapper.class);
	
	@Mapping(target = "dateStr", expression = "java(DateUtils.getDateTime(dateStringBeanSource.getDateStr()))")
	DateStringBeanDest getDateStringBeanDest(DateStringBeanSource dateStringBeanSource);
			
}
