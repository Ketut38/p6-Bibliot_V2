package org.occ.p3.service;

import org.occ.p3.consumer.repository.WorkRepository;
import org.occ.p3.model.Book;
import org.occ.p3.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {
	@Autowired
	WorkRepository workRepository;

	@Override
	public List<Work> getWorksByAuthor(String author) {

		/// Appeler le consumer

		List<Work> worksGotFromConsumer = workRepository.findByAuthorIsContainingIgnoreCase(author);

		return worksGotFromConsumer;
	}

	@Override
	public List<Work> getWorksByPublicationDate(Integer publicationDate) {

		/// Appeler le consumer

		List<Work> worksGotFromConsumer = workRepository.findByPublicationDate(publicationDate);

		return worksGotFromConsumer;

	}

	@Override
	public boolean isReservable(Integer workId) {

		boolean isReservable = false;

		// Recuperer le Work dont on connait l'ID
		Work myWorkGot = workRepository.findById(workId).get();

		// recuperer la liste de livre de l'oeuvre
		Integer maxRes = myWorkGot.getReservationRealized();

		// verifier si reservable
		if (maxRes < 5) {

			isReservable = true;

		}
		return isReservable;
	}

	@Override
	public boolean isBorrowable(Integer workId) {

		boolean isBorrowable = false;

		Work work = workRepository.findById(workId).get();

		List<Book> workBookList = work.getBooksList();

		for (Book book : workBookList) {
			if (book.isAvailable()) {
				isBorrowable = true;
			}
		}
		return isBorrowable;
	}

}
