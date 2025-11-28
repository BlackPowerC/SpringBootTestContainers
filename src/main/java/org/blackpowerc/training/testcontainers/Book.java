package org.blackpowerc.training.testcontainers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter @Setter @AllArgsConstructor @Builder
@Entity
@NoArgsConstructor
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id ;

    @Column(nullable = false)
    private String author ;

    @Column(nullable = false)
    private String title ;

    @Column(nullable = false)
    private String isbn ;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String excerpt ;

    @Column(nullable = false)
    private Double price ;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false ;

        Book book = (Book) o ;

        return Objects.equals(id, book.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.id) ;
    }
}
