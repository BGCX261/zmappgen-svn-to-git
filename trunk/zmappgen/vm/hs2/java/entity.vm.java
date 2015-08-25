
package $entityPackage;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.zoom.appcore.utils.CollectionUtils;

@MappedSuperclass
@Entity
@Table(name = "${obj.tableName}")
public class ${uobjname} {

	private Long id;
	
#foreach( $metaData in $obj.metaDatas )
 #if($metaData.attributeName != "id")
    // $metaData.description
    private $metaData.attributeType $metaData.attributeName;
 #end
#end

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


#foreach( $metaData in $obj.metaDatas )
  #if($metaData.attributeName != "id")
    public $metaData.attributeType get${metaData.capitalizeAttributeName}() {
        return $metaData.attributeName;
    }

    public void set${metaData.capitalizeAttributeName}($metaData.attributeType $metaData.attributeName) {
        this.$metaData.attributeName=$metaData.attributeName;
    }
  #end
#end


    public void emptystringToNull(){
#foreach( $metaData in $obj.metaDatas )
  #if($metaData.attributeType == "String")
      if("".equals(${metaData.attributeName}))${metaData.attributeName}=null;
  #end
#end
    }

}