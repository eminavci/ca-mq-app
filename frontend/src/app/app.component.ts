import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { PartnerComponent } from './components/partner/partner.component';
import { QmComponent } from './components/qm/qm.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PartnerComponent, QmComponent, RouterLink, RouterLinkActive],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
