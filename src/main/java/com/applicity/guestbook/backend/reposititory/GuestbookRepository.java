package com.applicity.guestbook.backend.reposititory;

import com.applicity.guestbook.backend.entity.GuestbookEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by me on 10.12.17.
 */
public interface GuestbookRepository extends JpaRepository<GuestbookEntry, Long> {

    public List<GuestbookEntry> findAllByOrderByIdDesc();

}
