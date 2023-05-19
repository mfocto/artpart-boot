package org.ict.artpart.emp.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmpEntity is a Querydsl query type for EmpEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmpEntity extends EntityPathBase<EmpEntity> {

    private static final long serialVersionUID = 305489276L;

    public static final QEmpEntity empEntity = new QEmpEntity("empEntity");

    public final StringPath empAddress = createString("empAddress");

    public final StringPath empCar = createString("empCar");

    public final StringPath empDepartmentId = createString("empDepartmentId");

    public final DateTimePath<java.time.LocalDateTime> empDepartureDate = createDateTime("empDepartureDate", java.time.LocalDateTime.class);

    public final StringPath empEmail = createString("empEmail");

    public final DateTimePath<java.time.LocalDateTime> empHireDate = createDateTime("empHireDate", java.time.LocalDateTime.class);

    public final StringPath empId = createString("empId");

    public final NumberPath<Integer> empIdx = createNumber("empIdx", Integer.class);

    public final StringPath empImg = createString("empImg");

    public final StringPath empImgUp = createString("empImgUp");

    public final StringPath empJobId = createString("empJobId");

    public final StringPath empName = createString("empName");

    public final StringPath empPermanentId = createString("empPermanentId");

    public final StringPath empPhone = createString("empPhone");

    public final StringPath empPwd = createString("empPwd");

    public QEmpEntity(String variable) {
        super(EmpEntity.class, forVariable(variable));
    }

    public QEmpEntity(Path<? extends EmpEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmpEntity(PathMetadata metadata) {
        super(EmpEntity.class, metadata);
    }

}

