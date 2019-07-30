import { Component, OnInit } from '@angular/core';
import {FakeSessionItemService} from '../fake-session-item.service';
import {SessionHttpService} from '../session-http.service';
import { FormateurHttpService } from '../../formateurs/formateur-http.service';
import { Formateur } from '../../formateurs/formateur';
import { Observable} from 'rxjs';
import { ParticipantHttpService } from '../../participants/participant-http.service';
import { Participant } from '../../participants/participant';
@Component({
  selector: 'app-session-add-form',
  templateUrl: './session-add-form.component.html',
  styleUrls: ['./session-add-form.component.css']
})
export class SessionAddFormComponent implements OnInit {
  formateurItems: Observable<Formateur[]>;
  participantItems: Observable<Participant[]>;
   constructor(private sessionItemService: FakeSessionItemService, private  sessionhttp: SessionHttpService,
    private  formateurhttp: FormateurHttpService, private participanthttp: ParticipantHttpService) { }
    ngOnInit() {
      this.formateurItems = this.formateurhttp.getFormateursObservable();
      this.participantItems = this.participanthttp.getParticipantsObservable(); 
      }
         
    
addSession(sessionItem) {
    console.log(sessionItem['formateur']);
      const session = {
     "name": sessionItem['name'],
    "track":sessionItem['track'],
    "date":sessionItem['date'],
    "duree": sessionItem['duree'],
    "adress": sessionItem['adress'],
    "participants": sessionItem['participants'],
    "isCompleted": false
    };
    console.log(session);

    this.sessionhttp.addSessionf(session, sessionItem['formateur']).subscribe(res => {
        console.log(res);
      }, (err) => {
        console.log(err);
      });
      console.log(session);

    this.sessionhttp.addSessionp(session, sessionItem['participant']).subscribe(res => {
        console.log(res);
      }, (err) => {
        console.log(err);
      });
  }
}

