
package $entityPackage;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ${entityClassname} {

#foreach( $column in $table.columns )
    // $column.description
    private $column.attributeType $column.attributeName;
    
#end

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

#foreach( $column in $table.columns )
    /**
     * get $column.description
     */    
    public $column.attributeType get${stringUtils.capitalize($column.attributeName)}() {
        return $column.attributeName;
    }

    /**
     * set $column.description
     */  
    public void set${stringUtils.capitalize($column.attributeName)}($column.attributeType $column.attributeName) {
        this.$column.attributeName=$column.attributeName;
    }
#end

}