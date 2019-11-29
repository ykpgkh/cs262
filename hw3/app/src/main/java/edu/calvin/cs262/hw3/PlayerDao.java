package edu.calvin.cs262.hw3;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * PlayerDao (data access object) allows easy interaction with db Player table
 */
@Dao
public interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Player player);

    @Query("DELETE FROM player_table")
    void deleteAll();

    @Delete
    void deletePlayer(Player player);

    @Query("SELECT * from player_table ORDER BY playerName ASC")
    LiveData<List<Player>> getAllPlayers();

    @Query("SELECT * from player_table LIMIT 1")
    Player[] getAnyPlayer();
}