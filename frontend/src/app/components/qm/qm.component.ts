import { Component, inject, OnInit, signal } from '@angular/core';
import { QMMessage, RestResponse } from '../../models/RestResponse';
import { MQService } from '../../services/mq.service';

@Component({
  selector: 'app-qm',
  standalone: true,
  imports: [],
  templateUrl: './qm.component.html',
  styleUrl: './qm.component.css'
})
export class QmComponent implements OnInit {

  isPopupOpen = signal(false);
  qmMessages: QMMessage[] = []
  qmSelected = new QMMessage();
  qmService = inject(MQService)


  loadAllMessages(){
    this.qmService.getAllMessages().subscribe((res: RestResponse) => {
      this.qmMessages = res.data;
    })
  }

  ngOnInit(): void {
      this.loadAllMessages();
  }

}
