package rs.ac.uns.ftn.BookingBaboon.services.users;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rs.ac.uns.ftn.BookingBaboon.domain.users.User;
import rs.ac.uns.ftn.BookingBaboon.repositories.users.IUserRepository;
import rs.ac.uns.ftn.BookingBaboon.services.users.interfaces.IUserService;

import java.util.*;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final IUserRepository repository;
    ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", LocaleContextHolder.getLocale());

    @Override
    public Collection<User> getAll() {
        return new ArrayList<User>(repository.findAll());
    }

    @Override
    public User get(Long userId) throws ResponseStatusException {
        Optional<User> found = repository.findById(userId);
        if (found.isEmpty()) {
            String value = bundle.getString("user.notFound");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, value);
        }
        return found.get();
    }

    @Override
    public User create(User user) throws ResponseStatusException {
        try {
            repository.save(user);
            repository.flush();
            return user;
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
            StringBuilder sb = new StringBuilder(1000);
            for (ConstraintViolation<?> error : errors) {
                sb.append(error.getMessage()).append("\n");
            }
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, sb.toString());
        }
    }

    @Override
    public User update(User user) throws ResponseStatusException {
        try {
            get(user.getId());
            repository.save(user);
            repository.flush();
            return user;
        } catch (RuntimeException ex) {
            Throwable e = ex;
            Throwable c = null;
            while ((e != null) && !((c = e.getCause()) instanceof ConstraintViolationException) ) {
                e = (RuntimeException) c;
            }
            if ((c != null) && (c instanceof ConstraintViolationException)) {
                ConstraintViolationException c2 = (ConstraintViolationException) c;
                Set<ConstraintViolation<?>> errors = c2.getConstraintViolations();
                StringBuilder sb = new StringBuilder(1000);
                for (ConstraintViolation<?> error : errors) {
                    sb.append(error.getMessage() + "\n");
                }
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, sb.toString());
            }
            throw ex;
        }
    }

    @Override
    public User remove(Long userId) {
        User found = get(userId);
        repository.delete(found);
        repository.flush();
        return found;
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
        repository.flush();
    }

    @Override
    public User login(String email, String password) {
        return new User();
    }

    @Override
    public User activate(Long userId) {
        return new User();
    }

    @Override
    public User changePassword(Long userId, String password) {
        return new User();
    }


}
