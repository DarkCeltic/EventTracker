import { Component, OnInit } from '@angular/core';
import { Events } from 'src/app/models/events';
import { EventTrackerService } from 'src/app/services/event-tracker.service';

@Component({
  selector: 'app-event-page',
  templateUrl: './event-page.component.html',
  styleUrls: ['./event-page.component.css']
})
export class EventPageComponent implements OnInit {
  displayedColumns = ['eventId', 'eventName', 'eventLocation', 'date', 'time'];
  dataSource: Events[];
  constructor(private eventService: EventTrackerService) { }

  ngOnInit(): void {
    setTimeout(() => {
      this.eventService.getAllEvents()
        .subscribe(events => {
          this.dataSource = events;
          console.log(this.dataSource);
        })
    }, 1000);
  }
}
