
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
@Table(name = "${table.tableName}")
public class ${entityClassname} {

	private Long id;
	
#foreach( $column in $table.columns )
 #if($column.attributeName != "id")
    // $column.description
    private $column.attributeType $column.attributeName;
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


#foreach( $column in $table.columns )
  #if($column.attributeName != "id")
    public $column.attributeType get${stringUtils.capitalize($column.attributeName)}() {
        return $column.attributeName;
    }

    public void set${stringUtils.capitalize($column.attributeName)}($column.attributeType $column.attributeName) {
        this.$column.attributeName=$column.attributeName;
    }
  #end
#end

}