//package kz.arab.SingularityHackathon.demo.service;
//
//import kz.arab.SingularityHackathon.demo.dto.UserRoleDto;
//import kz.arab.SingularityHackathon.demo.repository.UserRolesRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RoleServiceImpl implements RoleService{
//
//    private final UserRolesRepository userRolesRepository;
//
//    @Autowired
//    public RoleServiceImpl(UserRolesRepository userRolesRepository) {
//        this.userRolesRepository = userRolesRepository;
//    }
//
//    @Override
//    public void setUserRole(Long userId, Long roleId) {
//        UserRoleDto userRoleDto = new UserRoleDto(userId, roleId);
//        userRolesRepository.save(userRoleDto);
//    }
//}
